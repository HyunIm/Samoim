package com.kb.samoim.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

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
			@Autowired RecommendDao recommendDao,
			@Autowired UserDao userDao
	) {
		this.recommendDao = recommendDao;
	}
	
	public void createRecommend(String email) throws IOException {
		UserDto findUser = this.userDao.findByEmail(email);
		System.out.println(findUser.toString());
		
        String payload = "{\"input_data\": [{\"fields\": [\"나이\", \"성별\", \"관심사1\",\"관심사2\", \"관심사3\", \"활동\"], \"values\": [[28,0,0,3,7,1], [26,0,1,4,6,6]]}]}";
		MLfunction(payload);
	}
	
	//행사에 해당하는 code로 불러오기
	public SCategoryDto getRecommendData(int code) {
		SCategoryDto result = new SCategoryDto();
		SCategoryDto findCategory = this.recommendDao.getRecommendData(code);
		if(findCategory == null ) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		
		result.setName(findCategory.getName());
		result.setPhoto_path(findCategory.getPhoto_path());
		
		return result;
	}
	
	public void MLfunction(String newPayload) throws IOException {
		String API_KEY = "nbaWdZ6hp9LfNnq9J83w7x5lzzSZw8uY-wrZfJ8uHsiD";

        HttpURLConnection tokenConnection = null;
        HttpURLConnection scoringConnection = null;
        BufferedReader tokenBuffer = null;
        BufferedReader scoringBuffer = null;
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
            String payload = "{\"input_data\": [{\"fields\": [\"나이\", \"성별\", \"관심사1\",\"관심사2\", \"관심사3\", \"활동\"], \"values\": [[28,0,0,3,7,1], [26,0,1,4,6,6]]}]}";
            writer.write(payload);
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

            String activitySimilarity = obj.getJSONArray("predictions").getJSONObject(0).getJSONArray("values").getJSONArray(0).getJSONArray(0).getJSONArray(1).get(0).toString();
            System.out.println("4. activity similarity result: " + activitySimilarity);
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
	}
	
}