package exam.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@SecondaryTable(name = "students")
@SecondaryTable(name = "teachers")
@Table(schema = "public", name = "teachers_students")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(table = "students", name = "private_id", referencedColumnName = "private_id")
    })
    private Student student;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(table = "teachers", name = "private_id_t", referencedColumnName = "private_id_t")
    })
    private Teacher teacher;
}


