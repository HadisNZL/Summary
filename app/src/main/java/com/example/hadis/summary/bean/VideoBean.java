package com.example.hadis.summary.bean;

import java.io.Serializable;

public class VideoBean implements Serializable {
	private VideoData data;

	public VideoData getData() {
		return data;
	}

	public void setData(VideoData data) {
		this.data = data;
	}

}
