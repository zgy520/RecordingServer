package com.app.record.record2.model;

import java.io.Serializable;

public class GPS implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int locationType;  //��ȡ��ǰ��λ�����Դ�������綨λ����������λ���ͱ�
    private double latitude;  //ά��
    private double longitude;  //����
    private float accuracy;  //��λ������Ϣ
    private float bear;  //�����
    private String address;  //��ַ
    private String country; //������Ϣ
    private String province; //ʡ��Ϣ
    private String city;  //������Ϣ
    private String district;  //������Ϣ
    private String street;  //�ֵ���Ϣ
    private String streetNum;  //�ֵ����ƺ���Ϣ
    private String cityCode;  //���б���
    private String adCode;  //��������
    private String aoiName;  //��ȡ��ǰ��λ���AOI��Ϣ
    private String buildingId;  //��ȡ��ǰ���ڶ�λ�Ľ�����Id
    private String floor;  //��ǰ���ڶ�λ��¥��
    private int gpsStatus;  //GPS�ĵ�ǰ״̬
    private String locationDetail;  //��λ��Ϣ����
    private String errorInfo;  //������Ϣ����
    private int errorCode;  //��λ������
	public int getLocationType() {
		return locationType;
	}
	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public float getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}
	public float getBear() {
		return bear;
	}
	public void setBear(float bear) {
		this.bear = bear;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNum() {
		return streetNum;
	}
	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getAdCode() {
		return adCode;
	}
	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}
	public String getAoiName() {
		return aoiName;
	}
	public void setAoiName(String aoiName) {
		this.aoiName = aoiName;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public int getGpsStatus() {
		return gpsStatus;
	}
	public void setGpsStatus(int gpsStatus) {
		this.gpsStatus = gpsStatus;
	}
	public String getLocationDetail() {
		return locationDetail;
	}
	public void setLocationDetail(String locationDetail) {
		this.locationDetail = locationDetail;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
    
}
