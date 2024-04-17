package OSSP214.taxmap.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


// 보조금 정보, column이 다 varchar(255)라서 정리 필요
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subsidy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String govOffice;

    private String financialYear;

    private String businessYear;

    private String businessName;

    @ManyToOne
    @JsonBackReference // 순환 참조 해결 위해, DTO 구성 후 넘겨주는 방법으로 변경 필요
    @JoinColumn
    private Organization orgInfo;

    private String orgName;

    private String representativeName;

    private String phoneNumber;

    private String address;

    private String totalBusinessExpense;

    private String govExpense;

    private String localExpense;

    private String selfExpense;

    private String requestedSubsidy;

    private String govBudget;

    private String localBudget;

    private String requestedPaid;

    private String authorityPaid;

    @Column(columnDefinition = "TEXT")
    private String businessPurpose;

    @Column(columnDefinition = "TEXT")
    private String businessDescription;

    @Column(columnDefinition = "TEXT")
    private String businessDuration;

    @Column(columnDefinition = "TEXT")
    private String businessLocation;

    @Column(columnDefinition = "TEXT")
    private String subjectNumber;

    @Column(columnDefinition = "TEXT")
    private String miscExpense;

    @Column(columnDefinition = "TEXT")
    private String proceedsProcessMethod;

    @Column(columnDefinition = "TEXT")
    private String applierAsset;

    @Column(columnDefinition = "TEXT")
    private String expectedBenefit;

    @Column(columnDefinition = "TEXT")
    private String performanceGoal;

    @Column(columnDefinition = "TEXT")
    private String considerations;
}
