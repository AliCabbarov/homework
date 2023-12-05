package entity.embeded;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    String phoneNumber;
    String address;
    String email;
}
