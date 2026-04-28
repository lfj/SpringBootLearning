package com.lfj.demo.entity;

import com.lfj.demo.model.PersionTag;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="girlinfo")
public class GirlEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")/* 选择最合适的主键生成策略 */
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private String name;

    private int age;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "birth_time")
    @Temporal(TemporalType.TIME)
    private Date birthTime;

    @Column(name = "birth_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthTimestamp;

    @Transient/* 修饰不想保存的属性 */
    private String cupSize;

    @Lob
    @Column(name = "head_image")
    @Basic(fetch = FetchType.LAZY)/* 延迟加载 */
    private byte[] headImage;

    @Column(name = "persion_tag")
    @Enumerated(EnumType.ORDINAL) /* 在底层保存枚举类型*/
    private PersionTag persionTag;

    @Column(name = "persion_tag2")
    @Enumerated(EnumType.STRING) /* 在底层保存String类型*/
    private PersionTag persionTag2;

    @ElementCollection(targetClass = String.class) /* 该属性指定集合属性中集合元素的类型 */
    @CollectionTable(name = "school_inf1", joinColumns = @JoinColumn(name = "persion_id", nullable = false))
    @Column(name = "school_name")
    @OrderColumn(name = "list_order")
    private List<String> schools = new ArrayList<>();

//    @ElementCollection(targetClass = String.class)
//    @CollectionTable(name = "school1_inf", joinColumns = @JoinColumn(name = "persion_id", nullable = false))
//    @Column(name = "school1_name")
//    @OrderColumn(name = "array_order")
//    private String[] schools1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    public Date getBirthTimestamp() {
        return birthTimestamp;
    }

    public void setBirthTimestamp(Date birthTimestamp) {
        this.birthTimestamp = birthTimestamp;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public byte[] getHeadImage() {
        return headImage;
    }

    public void setHeadImage(byte[] headImage) {
        this.headImage = headImage;
    }

    public PersionTag getPersionTag() {
        return persionTag;
    }

    public void setPersionTag(PersionTag persionTag) {
        this.persionTag = persionTag;
    }

    public PersionTag getPersionTag2() {
        return persionTag2;
    }

    public void setPersionTag2(PersionTag persionTag2) {
        this.persionTag2 = persionTag2;
    }

    public List<String> getSchools() {
        return schools;
    }

    public void setSchools(List<String> schools) {
        this.schools = schools;
    }

//    public String[] getSchools1() {
//        return schools1;
//    }
//
//    public void setSchools1(String[] schools1) {
//        this.schools1 = schools1;
//    }
}
