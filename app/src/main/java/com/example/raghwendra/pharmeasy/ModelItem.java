package com.example.raghwendra.pharmeasy;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghawendra.kumar on 17-04-2016.
 */
public class ModelItem implements Parcelable {
    List<String> tags;
    OwnerClass owner;
    String is_answered;
    int view_count;
    int answer_count;
    int score;
    int last_activity_date;
    int creation_date;
    int last_edit_date;
    int question_id;
    String link;
    String title;

    public ModelItem() {
    }

    public ModelItem(List<String> tags, OwnerClass owner, String is_answered, int view_count, int answer_count, int score, int last_activity_date, int creation_date, int last_edit_date, int question_id, String link, String title) {
        this.tags = tags;
        this.owner = owner;
        this.is_answered = is_answered;
        this.view_count = view_count;
        this.answer_count = answer_count;
        this.score = score;
        this.last_activity_date = last_activity_date;
        this.creation_date = creation_date;
        this.last_edit_date =  last_edit_date;
        this.question_id = question_id;
        this.link = link;
        this.title = title;
    }

    public int getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(int last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public OwnerClass getOwner() {
        return owner;
    }

    public void setOwner(OwnerClass owner) {
        this.owner = owner;
    }

    public String getIs_answered() {
        return is_answered;
    }

    public void setIs_answered(String is_answered) {
        this.is_answered = is_answered;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(int last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public int getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(int creation_date) {
        this.creation_date = creation_date;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }


    protected ModelItem(Parcel in) {

        if(in.readByte() == 0x01){
            tags = new ArrayList<String>();
            in.readList(tags,String.class.getClassLoader());
        }
        owner = (OwnerClass) in.readValue(OwnerClass.class.getClassLoader());
        is_answered = in.readString();
        view_count = in.readInt();
        answer_count = in.readInt();
        score = in.readInt();
        last_activity_date = in.readInt();
        creation_date = in.readInt();
        last_edit_date = in.readInt();
        question_id = in.readInt();
        link = in.readString();
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if(tags == null){
            dest.writeByte((byte)(0x00));
        }else
        {
            dest.writeByte((byte)(0x01));
            dest.writeList(tags);
        }
        dest.writeValue(owner);
        dest.writeString(is_answered);
        dest.writeInt(view_count);
        dest.writeInt(answer_count);
        dest.writeInt(score);
        dest.writeInt(last_activity_date);
        dest.writeInt(creation_date);
        dest.writeInt(last_edit_date);
        dest.writeInt(question_id);
        dest.writeString(link);
        dest.writeString(title);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ModelItem> CREATOR = new Parcelable.Creator<ModelItem>() {
        @Override
        public ModelItem createFromParcel(Parcel in) {
            return new ModelItem(in);
        }

        @Override
        public ModelItem[] newArray(int size) {
            return new ModelItem[size];
        }
    };
}