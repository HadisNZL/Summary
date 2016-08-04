package com.example.hadis.summary.bean;

import java.io.Serializable;
import java.util.List;

public class VideoData implements Serializable {
	private String count;
	private List<VideoDeatils> data2;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<VideoDeatils> getData2() {
		return data2;
	}

	public void setData2(List<VideoDeatils> data2) {
		this.data2 = data2;
	}

}
