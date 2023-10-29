package studio.aroundhub.onehourproject.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import studio.aroundhub.onehourproject.member.controller.dto.JoinRequest;
import studio.aroundhub.onehourproject.member.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/hello")
  public String getHello() {
    return "hello";
  }

  @PostMapping("/join")
  public String createUser(@RequestBody JoinRequest joinRequest) {
    String result = memberService.join(joinRequest);

    if ("success".equalsIgnoreCase(result)) {
      return "success";
    } else {
      return "fail";
    }
  }

}
