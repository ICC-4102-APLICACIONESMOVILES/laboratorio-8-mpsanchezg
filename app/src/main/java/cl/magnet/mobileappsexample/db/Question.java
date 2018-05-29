package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;


@Entity
public class Question {
    @PrimaryKey
    private int qid;

    @ColumnInfo(name = "question")
    private String question;

    @ForeignKey(entity = Form.class, parentColumns = "FormID", childColumns = "FormID")
    private int formId;

    public Question(int qid, String question, int formId) {
        this.qid = qid;
        this.question = question;
        this.formId = formId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }
}
