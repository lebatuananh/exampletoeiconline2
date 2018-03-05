package vn.mra.core.peristence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by tuana on 2/27/2018.
 */
@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "createdate")
    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private RoleEntity role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    public void setUserId(Integer userId) {

        this.userId = userId;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public void setCreateDate(Timestamp createDate) {

        this.createDate = createDate;
    }

    public Integer getUserId() {

        return userId;
    }

    public String getName() {

        return name;
    }

    public String getPassword() {

        return password;
    }

    public String getFullName() {

        return fullName;
    }

    public Timestamp getCreateDate() {

        return createDate;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
