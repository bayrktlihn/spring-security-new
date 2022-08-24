package io.bayrktlihn.springsecuritytutorial.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notice")
@Getter
@Setter
@NoArgsConstructor
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_id")
    private long noticeId;

    @Column(name = "notice_summary", length = 200)
    private String noticeSummary;


    @Column(name = "notice_details", length = 500)
    private String noticeDetails;

    @Column(name = "notic_beg_dt")
    @Temporal(TemporalType.DATE)
    private Date noticBegDt;

    @Column(name = "notic_end_dt")
    @Temporal(TemporalType.DATE)
    private Date noticEndDt;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_dt")
    private Date createDt;

    @Column(name = "update_dt")
    private Date updateDt;

    public Notice(String noticeSummary, String noticeDetails, Date noticBegDt, Date noticEndDt, Date createDt, Date updateDt) {
        this.noticeSummary = noticeSummary;
        this.noticeDetails = noticeDetails;
        this.noticBegDt = noticBegDt;
        this.noticEndDt = noticEndDt;
        this.createDt = createDt;
        this.updateDt = updateDt;
    }
}
