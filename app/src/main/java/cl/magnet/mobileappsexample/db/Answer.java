package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mpsan on 29-05-2018.
 */
@Entity
public class Answer {
    @PrimaryKey
    private int aid;

    @ColumnInfo(name = "answer")
    private String answer;

    @ForeignKey(entity = Question.class, parentColumns = "QuestionID", childColumns = "QuestionID")
    private int questionId;

    public Answer(int aid, String answer, int questionId) {
        this.aid = aid;
        this.answer = answer;
        this.questionId = questionId;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
