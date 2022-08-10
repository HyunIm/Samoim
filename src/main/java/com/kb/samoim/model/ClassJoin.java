package com.kb.samoim.model;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@ApiModel(value = "모임 참가 정보", description  = "사용자 ID (이메일), 참여할 모임 식별 ID를 가진 Domain Class")
public class ClassJoin {
//	private long id;
	@ApiModelProperty(value = "참여할 모임 식별 ID")
	private long classId;
	@ApiModelProperty(value = "사용자 ID (이메일)")
	private String userId;
//	private Timestamp joinDate;
}
