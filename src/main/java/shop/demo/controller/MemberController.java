package shop.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.demo.dto.MemberDTO;
import shop.demo.dto.MemberInfoDTO;
import shop.demo.dto.OrderDTO;
import shop.demo.service.MemberService;
import shop.demo.domain.Member;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
//    @PostMapping("/add")
//    public String addMember(@RequestBody Member member) {
//        memberService.saveMember(member);
//        return "add success";
//    }

    //    @PostMapping("/add")
//    public ResponseEntity<String> addMember(@RequestParam Long id,
//                                            @RequestParam String name,
//                                            @RequestParam String email,
//                                            @RequestParam String password) {
//
//    }
    @PostMapping("/add")
    public ResponseEntity<String> addMember(@RequestBody MemberDTO memberDTO) {
        memberService.saveMember(memberDTO);
        return ResponseEntity.ok("회원 추가");
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberInfoDTO> getMemberById(@PathVariable Long id) {
        MemberInfoDTO memberInfoDTO = memberService.findMemberById(id);
        if (memberInfoDTO != null)
            return ResponseEntity.ok(memberInfoDTO);
        else return ResponseEntity.notFound().build();
    }


//
//    @GetMapping("/member/{memberId}")
//    public ResponseEntity<List<MemberDTO>> getMemberById(@PathVariable Long memberId) {
//        List<MemberDTO> memberDTOs = memberService.findMemberById(memberId)
////        List<OrderDTO> orderDTOs = orderService.viewOrdersByMemberId(memberId);
//        return ResponseEntity.ok(orderDTOs);
//    }
//
//
//    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

//    @GetMapping("/{id}")
//    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
//        Member member = memberService.findMemberById(id);
//        if (member != null) {
//            return ResponseEntity.ok(member);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

//    @GetMapping("/{id}")
//    public Member getMemberById(@PathVariable Long id) {
//        return memberService.findMemberById(id);
//    }

//    @GetMapping("/all")
//    public List<Member> getAllMembers() {
//        return memberService.findAllMembers();
//    }

//    @GetMapping("/search")
//    public List<Member> searchMembersByName(@RequestParam String name) {
//        return memberService.findMembersByName(name);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable Long id) {
        if (memberService.deleteMemberById(id)) {
            return ResponseEntity.ok("회원 삭제");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
