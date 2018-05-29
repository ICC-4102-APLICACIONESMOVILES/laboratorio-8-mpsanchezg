package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mpsan on 29-05-2018.
 */
@Entity
public class Question {
    @PrimaryKey
    private int qid;

    @ColumnInfo(name = "name")
    private String question;

    @ForeignKey(entity = Form.class, parentColumns = "FormID", childColumns = "FormID")
    private int formId;

    public Question(int qid, String name, int getUid) {
        this.qid = qid;
        this.question = name;
        this.formId = getUid;
    }
}
