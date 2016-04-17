package com.example.raghwendra.pharmeasy;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by raghawendra.kumar on 17-04-2016.
 */
public class OwnerClass implements Parcelable{
    int reputation;
    int user_id;
    String user_type;
    int accept_rate;
    String profile_image;
    String display_name;
    String link;

    public OwnerClass(){

    }
    public OwnerClass(int reputation, int user_id, String user_type, int accept_rate, String profile_image, String display_name, String link) {
        this.reputation = reputation;
        this.user_id = user_id;
        this.user_type = user_type;
        this.accept_rate = accept_rate;
        this.profile_image = profile_image;
        this.display_name = display_name;
        this.link = link;
    }

    protected OwnerClass(Parcel in) {
        reputation = in.readInt();
        user_id = in.readInt();
        user_type = in.readString();
        accept_rate = in.readInt();
        profile_image = in.readString();
        display_name = in.readString();
        link = in.readString();
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public int getAccept_rate() {
        return accept_rate;
    }

    public void setAccept_rate(int accept_rate) {
        this.accept_rate = accept_rate;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(reputation);
        dest.writeInt(user_id);
        dest.writeString(user_type);
        dest.writeInt(accept_rate);
        dest.writeString(profile_image);
        dest.writeString(display_name);
        dest.writeString(link);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<OwnerClass> CREATOR = new Parcelable.Creator<OwnerClass>() {
        @Override
        public OwnerClass createFromParcel(Parcel in) {
            return new OwnerClass(in);
        }

        @Override
        public OwnerClass[] newArray(int size) {
            return new OwnerClass[size];
        }
    };
}
