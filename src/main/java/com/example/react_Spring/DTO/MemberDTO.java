package com.example.react_Spring.DTO;
import com.example.react_Spring.Domain.Member;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Data
public class MemberDTO{
    private Long id;
    private String UserId;
    private String Name;
    private String Pwd;
    private String Email;
    private String SchoolId;
    private String Phone;
    private int Level;

    @Builder
    public MemberDTO(String UserId,String Name,String Pwd,String Email,String SchoolId,String Phone,int Level){
        this.UserId = UserId;
        this.Name = Name;
        this.Pwd = Pwd;
        this.Email = Email;
        this.SchoolId = SchoolId;
        this.Phone = Phone;
        this.Level = Level;
    }

    @Builder
    public MemberDTO(Member member){
        this.UserId = member.getUserid();
        this.Name = member.getName();
        this.Pwd = member.getPwd();
        this.Email = member.getEmail();
        this.SchoolId = member.getSchoolid();
        this.Phone = member.getPhone();
        this.Level = member.getLevel();
    }
}
