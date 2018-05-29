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

    @ColumnInfo(name = "name")
    private String answer;

    @ForeignKey(entity = Question.class, parentColumns = "FormID", childColumns = "FormID")
    private int questionId;

    public Answer(int qid, String name, int getUid) {
        this.aid = qid;
        this.answer = name;
        this.questionId = getUid;
    }
}
