package com.pakistan.adilfarooq.Model;

public class News {

    private String mImageUrl, mDescription;

    public News() {}

    public News(String mImageUrl, String mDescription) {
        this.mImageUrl = mImageUrl;
        this.mDescription = mDescription;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
