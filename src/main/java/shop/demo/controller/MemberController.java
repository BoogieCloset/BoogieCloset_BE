package shop.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import shop.demo.domain.Member;
import shop.demo.dto.*;
import shop.demo.service.CartService;
import shop.demo.service.MemberService;
import shop.demo.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final OrderService orderService;
    private final CartService cartService;


    @PostMapping("/add")
    public ResponseEntity<String> addMember(@RequestBody MemberDTO memberDTO) {
        memberService.saveMember(memberDTO);
        return ResponseEntity.ok("회원 추가");
    }


    /* 내정보 조회시 카트아이디, 주문아이디 공개 */
    /* 내정보 조회시 카트아이디, 주문아이디 공개 */
    /* 내정보 조회시 카트아이디, 주문아이디 공개 */
    /* 내정보 조회시 카트아이디, 주문아이디 공개 */

//    @GetMapping({"/detail/address"})

    @GetMapping("/{id}")
    public ResponseEntity<MemberInfoDTO> getMemberById(@AuthenticationPrincipal UserDetails userDetails,
                                                       @PathVariable Long id) {
        System.out.println(userDetails.getUsername());
        Member member = memberService.findMemberByEmail(userDetails.getUsername());
        Long memberId = member.getId();

        if (!memberId.equals(id)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        MemberInfoDTO memberInfoDTO = memberService.findMemberById(id);
        if (memberInfoDTO != null) {
            /* 수정 5.19 */
            List<CartDTO> cartDTOS = cartService.viewAllCart(id);
            List<OrderDTO> orderDTOS = orderService.viewOrdersByMemberId(id);
            memberInfoDTO.setCartDTOS(cartDTOS);
            memberInfoDTO.setOrderDTOS(orderDTOS);
            /* 수정 5.19 */
            return ResponseEntity.ok(memberInfoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    /* 5.13 수정된 코드 사용자 본인 검증 */
    /* 테스트하지 못하였음. token null 이슈 */
    /* 유저를 삭제하면 해당 카트, 주문도 삭제됨. */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMember(@AuthenticationPrincipal UserDetails userDetails,
                                             @PathVariable Long id) {

        // 현재 인증된 사용자의 이메일을 통해 회원정보 가져옴.
        Member member = memberService.findMemberByEmail(userDetails.getUsername());
        Long memberId = member.getId();


        // 요청된 id가 현재 사용자의 id와 일치하는지 확인.
        if (!memberId.equals(id))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();


        // 회원을 삭제
        // boolean으로 굳이 안해도 되긴 함. 그냥 이전 작성 코드 때문에 boolean사용
        boolean deleted = memberService.deleteMemberById(memberId);
        if (deleted)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /* 주소 수정 5.19 추가 */
    @PutMapping("/update-address/{id}")
    public ResponseEntity<String> updateMemberAddress(@AuthenticationPrincipal UserDetails userDetails,
                                                      @PathVariable Long id,
                                                      @RequestBody AddressUpdateDTO addressUpdateDTO) {
        Member member = memberService.findMemberByEmail(userDetails.getUsername());
        Long memberId = member.getId();

        if (!memberId.equals(id)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        memberService.updateMemberAddress(id, addressUpdateDTO);
        return ResponseEntity.ok("주소 업데이트.");
    }
    /* 주소 수정 */
}


