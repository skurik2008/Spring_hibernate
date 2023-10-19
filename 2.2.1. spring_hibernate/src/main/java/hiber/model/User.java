package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @JoinColumn(name = "car_id")
   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {return car;}

   public void setCar(Car car) {
      car.setUser(this);
      this.car = car;
   }

   @Override
   public String toString() {
       final StringBuilder sb = new StringBuilder("User{");
       sb.append("id=").append(getId());
       sb.append(", firstname='").append(getFirstName()).append('\'');
       sb.append(", lastName='").append(getLastName()).append('\'');
       sb.append(", email=").append(getEmail()).append('\'');
       sb.append(", car_id=").append(car != null ? car.getId() : null);
       sb.append('}');
       return sb.toString();
   }
}
