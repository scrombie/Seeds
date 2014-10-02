package com.codecamp14.seeds;

import org.json.JSONObject;

public class Campaign {
	/*{
		"id": "1",
		"title": "Space Rites: Interactive Installation & Performance Series",
		"brief": "Taylor Lee Shepherd's oscilloscopes will translate footsteps, voices and music into responsive visuals in the St. Maurice church.",
		"creator": "New Orleans airlift",
		"goal": "6000",
		"created": "2014-08-26 10:55:00",
		"goal_duration": "2014-09-04",
		"total_donations": "0",
		"total_donors": "0"
		},*/
	protected int id;
	protected String title;
	protected String desc;
	protected String creator;
	protected String timeCreated;
	protected String  goalDuration;
	protected int goal;
	protected int totalDonations;
	protected int totalDonors;
<<<<<<< HEAD
	protected String imageUrl;
		public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String image) {
		this.imageUrl = image;
=======
	protected String image;
		public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
	}
		Campaign(JSONObject json){
			try{
				this.id=json.getInt("id");
				this.title=json.getString("title");
				this.desc=json.getString("brief");
				this.creator=json.getString("creator");
				this.timeCreated=json.getString("created");
				this.goal=json.getInt("goal");
				this.goalDuration=json.getString("goal_duration");
				this.totalDonations=json.getInt("total_donations");
				this.totalDonors=json.getInt("total_donors");
<<<<<<< HEAD
				this.imageUrl=json.getString("photos");
=======
//				this.image=json.getString("image");
>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
				}catch(Exception m){
					m.printStackTrace();
				}
			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public String getTimeCreated() {
			return timeCreated;
		}
		public void setTimeCreated(String timeCreated) {
			this.timeCreated = timeCreated;
		}
		public String getGoalDuration() {
			return goalDuration;
		}
		public void setGoalDuration(String goalDuration) {
			this.goalDuration = goalDuration;
		}
		public int getGoal() {
			return goal;
		}
		public void setGoal(int goal) {
			this.goal = goal;
		}
		public int getTotalDonations() {
			return totalDonations;
		}
		public void setTotalDonations(int totalDonations) {
			this.totalDonations = totalDonations;
		}
		public int getTotalDonors() {
			return totalDonors;
		}
		public void setTotalDonors(int totalDonors) {
			this.totalDonors = totalDonors;
		}
		
	

}
