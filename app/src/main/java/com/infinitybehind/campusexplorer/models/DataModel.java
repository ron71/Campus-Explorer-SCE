package com.infinitybehind.campusexplorer.models;

public class DataModel {

    String placeName ="";
    int floor;
    String avatarName;
    String roomNo;
    float longitude;
    float latitude;


    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getFloor() {

        if(floor == 0)
            return "FLOOR : GRND";
        else
            return "FLOOR :"+floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
