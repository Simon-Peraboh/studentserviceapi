/**
 * Created By SPC On
 * Date:17/11/2023
 * Time:04:37
 * Project Name:spc.com.studentserviceapi.model
 */

package spc.com.studentserviceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "studentDetail")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String email;
}
