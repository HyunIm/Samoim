package com.kb.samoim.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kb.samoim.dao.RecommendDao;
import com.kb.samoim.dao.UserDao;
import com.kb.samoim.dto.SCategoryDto;
import com.kb.samoim.dto.UserDto;

@Service
public class RecommendService {
	
	private static final Logger logger = LoggerFactory.getLogger(RecommendService.class);
	private RecommendDao recommendDao;
	private UserDao userDao;
	
	public RecommendService(
			@Autowired UserDao userDao,
			@Autowired RecommendDao recommendDao
	) {
		this.recommendDao = recommendDao;
		this.userDao = userDao;
	}
	public List<SCategoryDto> createRecommend(String email) throws IOException {
		UserDto findUser = this.userDao.findByEmail(email);		
		if(findUser == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		int age = 2022 - Integer.parseInt(findUser.getBirth().substring(0, 4)); //
		logger.info("나이 체크" + age);
		int gender = 0;
		
		if(findUser.getGender().contains("여")) gender = 1;
		logger.info("성별 체크" + gender);
		
		
		List<String> interestList = new ArrayList<>();
		String [] interestArray = findUser.getInterest().split(",");
		for(String str : interestArray) {
			if(str.equals("운동")) interestList.add("0");
			if(str.equals("여행")) interestList.add("1");
			if(str.equals("문화")) interestList.add("2");
			if(str.equals("음악")) interestList.add("3");
			if(str.equals("창작")) interestList.add("4");
			if(str.equals("성장")) interestList.add("5");
			if(str.equals("봉사")) interestList.add("6");
			if(str.equals("요리")) interestList.add("7");
		}
		
		String newPayload = "";
		newPayload += "{\"input_data\": [{\"fields\": [\"나이\", \"성별\", \"관심사1\",\"관심사2\", \"관심사3\", \"활동\"], \"values\": [[";
		newPayload += Integer.toString(age)+",";
		newPayload += Integer.toString(gender)+",";
		
		Collections.shuffle(interestList);
		
		if(interestList.size()>=3) {
			for(int i=0;i<3;i++) {
				newPayload += (interestList.get(i)+",");
			}
		}
		else {
			int diff = 3 - interestList.size();
			for(int i=0;i<interestList.size();i++) {
				newPayload += (interestList.get(i)+",");
			}
			for(int i=0;i<diff;i++)
				newPayload += "-1,";
		}
		newPayload += "-1], [28,0,1,2,3,-1]]}]}";
        List<Integer> arrlist = MLfunction(newPayload);
        return this.recommendDao.getRecommendInterest(arrlist);
	}	
	
	public List<Integer> MLfunction(String newPayload) throws IOException{
        String API_KEY = "nbaWdZ6hp9LfNnq9J83w7x5lzzSZw8uY-wrZfJ8uHsiD";

        HttpURLConnection tokenConnection = null;
        HttpURLConnection scoringConnection = null;
        BufferedReader tokenBuffer = null;
        BufferedReader scoringBuffer = null;
        List<Integer> arrlist = new ArrayList<>();
        
        try {
            // Getting IAM token
            URL tokenUrl = new URL("https://iam.cloud.ibm.com/identity/token?grant_type=urn:ibm:params:oauth:grant-type:apikey&apikey=" + API_KEY);
            tokenConnection = (HttpURLConnection) tokenUrl.openConnection();
            tokenConnection.setDoInput(true);
            tokenConnection.setDoOutput(true);
            tokenConnection.setRequestMethod("POST");
            tokenConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            tokenConnection.setRequestProperty("Accept", "application/json");
            tokenBuffer = new BufferedReader(new InputStreamReader(tokenConnection.getInputStream()));
            StringBuffer jsonString = new StringBuffer();
            String line;
            while ((line = tokenBuffer.readLine()) != null) {
                jsonString.append(line);
            }
            // Scoring request
            URL scoringUrl = new URL("https://us-south.ml.cloud.ibm.com/ml/v4/deployments/c7859545-b4cf-411c-8fdc-2466288ce5f0/predictions?version=2022-08-15");
            String iam_token = "Bearer " + jsonString.toString().split(":")[1].split("\"")[1];
            scoringConnection = (HttpURLConnection) scoringUrl.openConnection();
            scoringConnection.setDoInput(true);
            scoringConnection.setDoOutput(true);
            scoringConnection.setRequestMethod("POST");
            scoringConnection.setRequestProperty("Accept", "application/json");
            scoringConnection.setRequestProperty("Authorization", iam_token);
            scoringConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            OutputStreamWriter writer = new OutputStreamWriter(scoringConnection.getOutputStream(), "UTF-8");

            // NOTE: manually define and pass the array(s) of values to be scored in the next line
            // 데이터 2개 넣어서 한 번에 판별 시도 합니다.
            String payload = "{\"input_data\": [{\"fields\": [\"나이\", \"성별\", \"관심사1\",\"관심사2\", \"관심사3\", \"활동\"], \"values\": [[28,0,1,1,1,-1], [22,0,0,0,0,-1]]}]}";
            writer.write(newPayload);
            writer.close();

            scoringBuffer = new BufferedReader(new InputStreamReader(scoringConnection.getInputStream()));
            StringBuffer jsonStringScoring = new StringBuffer();
            String lineScoring;
            while ((lineScoring = scoringBuffer.readLine()) != null) {
                jsonStringScoring.append(lineScoring);
            }
            System.out.println("1. Score result: " + jsonStringScoring);
            String objString = jsonStringScoring +"";

            JSONObject obj = new JSONObject(objString);
            String predicArray = obj.getJSONArray("predictions").getJSONObject(0).getJSONArray("values").getJSONArray(0).toString();
            System.out.println("2. predict array: "+ predicArray);

            String activity = obj.getJSONArray("predictions").getJSONObject(0).getJSONArray("values").getJSONArray(0).getJSONArray(0).get(0).toString();
            System.out.println("3. activity result: " + activity);
            
            String activity2 = obj.getJSONArray("predictions").getJSONObject(0).getJSONArray("values").getJSONArray(0).getJSONArray(1).get(0).toString();
            System.out.println("5. activity2 result: " + activity2);
            
            arrlist.add(Integer.parseInt(activity));
            System.out.println("여기서 에러?");
            arrlist.add(Integer.parseInt(activity2));
            System.out.println("아니면 여기 에러?");

            
        } catch (IOException e) {
            System.out.println("The URL is not valid.");
            System.out.println(e.getMessage());
        }
        finally {
            if (tokenConnection != null) {
                tokenConnection.disconnect();
            }
            if (tokenBuffer != null) {
                tokenBuffer.close();
            }
            if (scoringConnection != null) {
                scoringConnection.disconnect();
            }
            if (scoringBuffer != null) {
                scoringBuffer.close();
            }
        }
        return arrlist;
	}
}