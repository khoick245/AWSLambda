package fitnessapp;

import java.util.ArrayList;
import java.util.List;

public class Response {
	List<BodyPartInfor> bodyPartInfors = new ArrayList<>();

	public List<BodyPartInfor> getBodyPartInfors() {
		return bodyPartInfors;
	}

	public void setBodyPartInfors(List<BodyPartInfor> bodyPartInfors) {
		this.bodyPartInfors = bodyPartInfors;
	}
}
