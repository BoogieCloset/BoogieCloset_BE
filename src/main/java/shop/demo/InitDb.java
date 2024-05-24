package shop.demo;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shop.demo.domain.*;
import shop.demo.dto.MemberDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 종 주문 2개
 * * userA
 * 	 * JPA1 BOOK
 * 	 * JPA2 BOOK
 * * userB
 * 	 * SPRING1 BOOK
 * 	 * SPRING2 BOOK
 */

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();

    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        private final PasswordEncoder passwordEncoder;

        public void dbInit1() {
            System.out.println("Init1" + this.getClass());
            Member admin = createADMIN(createTestAdminDTO(), passwordEncoder);
            em.persist(admin);
            Member member = Member.createMember(createTestMemberDTO(), passwordEncoder);
            em.persist(member);

            //상품 데이터
            Item outer1 = createItem("Cotton Double Long Trench Coat", 64900, Category.OUTER, "Cotton Double Long Trench Coat.JPG");
            Item outer2 = createItem("Cotton Trucker Jumper", 52000, Category.OUTER, "Cotton Trucker Jumper.JPG");
            Item outer3 = createItem("Duck Pattern Color Blocked Cardigan", 33000, Category.OUTER, "Duck Pattern Color Blocked Cardigan.JPG");
            Item outer4 = createItem("Heart Pattern Jacket", 39000, Category.OUTER, "Heart Pattern Jacket.JPG");
            Item outer5 = createItem("High Neck Contrast Binding Zipper Jacket", 48800, Category.OUTER, "High Neck Contrast Binding Zipper Jacket.JPG");
            Item outer6 = createItem("High Neck Nylon Jumper", 29000, Category.OUTER, "High Neck Nylon Jumper.JPG");
            Item outer7 = createItem("Long-sleeve Zip-up Hoodie", 28000, Category.OUTER, "Long-sleeve Zip-up Hoodie.JPG");
            Item outer8 = createItem("Shirt Style Denim Jacket", 35000, Category.OUTER, "Shirt Style Denim Jacket.JPG");
            Item outer9 = createItem("Single Collar Short Jacket", 54200, Category.OUTER, "Single Collar Short Jacket.JPG");
            Item outer10 = createItem("Single Collar Stitch Crop Jacket", 36000, Category.OUTER, "Single Collar Stitch Crop Jacket.JPG");
            Item outer11 = createItem("Tailored Belted Jacket", 47800, Category.OUTER, "Tailored Belted Jacket.JPG");
            Item outer12 = createItem("Zip-up Buckle Jacket", 38000, Category.OUTER, "Zip-up Buckle Jacket.JPG");
            em.persist(outer1); em.persist(outer2); em.persist(outer3); em.persist(outer4);
            em.persist(outer5); em.persist(outer6); em.persist(outer7); em.persist(outer8);
            em.persist(outer9); em.persist(outer10); em.persist(outer11); em.persist(outer12);

            Item top1 = createItem("Collar Pocket Sweatshirt", 31000, Category.TOP, "Collar Pocket Sweatshirt.JPG");
            Item top2 = createItem("Diagonal Wrap Cardigan", 28900, Category.TOP, "Diagonal Wrap Cardigan.JPG");
            Item top3 = createItem("Half Neck T-shirt", 22000, Category.TOP, "Half Neck T-shirt.JPG");
            Item top4 = createItem("Hoodie", 25000, Category.TOP, "Hoodie.JPG");
            Item top5 = createItem("Lettering Short Sleeve Shirt", 23000, Category.TOP, "Lettering Short Sleeve Shirt.JPG");
            Item top6 = createItem("Long Sleeve Striped Sweatshirt", 36000, Category.TOP, "Long Sleeve Striped Sweatshirt.JPG");
            Item top7 = createItem("Pearl Floral Short-sleeve T-shirt", 18900, Category.TOP, "Pearl Floral Short-sleeve T-shirt.JPG");
            Item top8 = createItem("Round Neck Crop Sweatshirt", 33000, Category.TOP, "Round Neck Crop Sweatshirt.JPG");
            Item top9 = createItem("Short Sleeve Shirt", 35300, Category.TOP, "Short Sleeve Shirt.JPG");
            Item top10 = createItem("Striped knit round neck long-sleeve top", 39000, Category.TOP, "Striped knit round neck long-sleeve top.JPG");
            Item top11 = createItem("Striped Wrap Shirt", 34000, Category.TOP, "Striped Wrap Shirt.JPG");
            Item top12 = createItem("Vegetable Short-Sleeve T-shirt", 21800, Category.TOP, "Vegetable Short-Sleeve T-shirt.JPG");
            em.persist(top1); em.persist(top2); em.persist(top3); em.persist(top4);
            em.persist(top5); em.persist(top6); em.persist(top7); em.persist(top8);
            em.persist(top9); em.persist(top10); em.persist(top11); em.persist(top12);

            Item pants1 = createItem("Cotton Wide Pants", 37800, Category.PANTS, "Cotton Wide Pants.JPG");
            Item pants2 = createItem("Destroyed Denim Shorts", 34000, Category.PANTS, "Destroyed Denim Shorts.JPG");
            Item pants3 = createItem("Elastic Wide Pants", 22000, Category.PANTS, "Elastic Wide Pants.JPG");
            Item pants4 = createItem("High Waisted Wide Slacks", 32000, Category.PANTS, "High Waisted Wide Slacks.JPG");
            Item pants5 = createItem("Layered Pants", 40900, Category.PANTS, "Layered Pants.JPG");
            Item pants6 = createItem("Linen Belted Wide Shorts", 29000, Category.PANTS, "Linen Belted Wide Shorts.JPG");
            Item pants7 = createItem("Poket Cotton Pants", 36000, Category.PANTS, "Poket Cotton Pants.JPG");
            Item pants8 = createItem("Semi-Bootcut Denim Pants", 44500, Category.PANTS, "Semi-Bootcut Denim Pants.JPG");
            Item pants9 = createItem("Turnup Wide Fit Denim", 34000, Category.PANTS, "Turnup Wide Fit Denim.JPG");
            Item pants10 = createItem("Wide Denim Pants", 38000, Category.PANTS, "Wide Denim Pants.JPG");
            Item pants11 = createItem("Wrap Skirt Pants", 29800, Category.PANTS, "Wrap Skirt Pants.JPG");
            Item pants12 = createItem("Zipper Detail Pants", 39000, Category.PANTS, "Zipper Detail Pants.JPG");
            em.persist(pants1); em.persist(pants2); em.persist(pants3); em.persist(pants4);
            em.persist(pants5); em.persist(pants6); em.persist(pants7); em.persist(pants8);
            em.persist(pants9); em.persist(pants10); em.persist(pants11); em.persist(pants12);

            Item skirt1 = createItem("A Line Long Skirt", 37000, Category.SKIRT, "A Line Long Skirt.JPG");
            Item skirt2 = createItem("Cargo Skirt", 33000, Category.SKIRT, "Cargo Skirt.JPG");
            Item skirt3 = createItem("Check Mini Skirt", 28900, Category.SKIRT, "Check Mini Skirt.JPG");
            Item skirt4 = createItem("Denim Maxi Skirt", 43000, Category.SKIRT, "Denim Maxi Skirt.JPG");
            Item skirt5 = createItem("Floral Layered Maxi Skirt", 48000, Category.SKIRT, "Floral Layered Maxi Skirt.JPG");
            Item skirt6 = createItem("H Line Long Skirt", 35000, Category.SKIRT, "H Line Long Skirt.JPG");
            Item skirt7 = createItem("Leather Mini Skirt", 31000, Category.SKIRT, "Leather Mini Skirt.JPG");
            Item skirt8 = createItem("Long Cargo Skirt", 35200, Category.SKIRT, "Long Cargo Skirt.JPG");
            Item skirt9 = createItem("Long Flare Skirt", 27000, Category.SKIRT, "Long Flare Skirt.JPG");
            Item skirt10 = createItem("Midi Skirt", 32000, Category.SKIRT, "Midi Skirt.JPG");
            Item skirt11 = createItem("Slit Mini Skirt", 19800, Category.SKIRT, "Slit Mini Skirt.JPG");
            Item skirt12 = createItem("Stitch Mini Skirt", 28000, Category.SKIRT, "Stitch Mini Skirt.JPG");
            em.persist(skirt1); em.persist(skirt2); em.persist(skirt3); em.persist(skirt4);
            em.persist(skirt5); em.persist(skirt6); em.persist(skirt7); em.persist(skirt8);
            em.persist(skirt9); em.persist(skirt10); em.persist(skirt11); em.persist(skirt12);

            Item dress1 = createItem("Floral Lace Mini Dress", 41900, Category.DRESS, "Floral Lace Mini Dress.JPG");
            Item dress2 = createItem("Floral Ruffle Hem Drawstring Midi Dress", 36000, Category.DRESS, "Floral Ruffle Hem Drawstring Midi Dress.JPG");
            Item dress3 = createItem("Floral Tie Ruffle Mini Dress", 34000, Category.DRESS, "Floral Tie Ruffle Mini Dress.JPG");
            Item dress4 = createItem("Floral Tie Shoulder Slit Midi Dress", 38000, Category.DRESS, "Floral Tie Shoulder Slit Midi Dress.JPG");
            Item dress5 = createItem("Jacquard Mini Dress", 44500, Category.DRESS, "Jacquard Mini Dress.JPG");
            Item dress6 = createItem("Lemon Shirred Midi Dress", 54000, Category.DRESS, "Lemon Shirred Midi Dress.JPG");
            Item dress7 = createItem("Mini Shirt Dress", 37000, Category.DRESS, "Mini Shirt Dress.JPG");
            Item dress8 = createItem("Nylon Layered Dress", 29800, Category.DRESS, "Nylon Layered Dress.JPG");
            Item dress9 = createItem("Round Neck Ribbon Midi Dress", 34000, Category.DRESS, "Round Neck Ribbon Midi Dress.JPG");
            Item dress10 = createItem("Square Neck Long Dress", 38000, Category.DRESS, "Square Neck Long Dress.JPG");
            Item dress11 = createItem("Strappy Flare Long Dress", 24900, Category.DRESS, "Strappy Flare Long Dress.JPG");
            Item dress12 = createItem("Velvet Long Dress", 32000, Category.DRESS, "Velvet Long Dress.JPG");
            em.persist(dress1); em.persist(dress2); em.persist(dress3); em.persist(dress4);
            em.persist(dress5); em.persist(dress6); em.persist(dress7); em.persist(dress8);
            em.persist(dress9); em.persist(dress10); em.persist(dress11); em.persist(dress12);

            Item shoes1 = createItem("Basic Flats", 31000, Category.SHOES, "Basic Flats.JPG");
            Item shoes2 = createItem("Buckle Single Band Slipper", 17500, Category.SHOES, "Buckle Single Band Slipper.JPG");
            Item shoes3 = createItem("Chunky Slingback Sandals", 47000, Category.SHOES, "Chunky Slingback Sandals.JPG");
            Item shoes4 = createItem("Cloud Sneakers", 34500, Category.SHOES, "Cloud Sneakers.JPG");
            Item shoes5 = createItem("Flat Sandals", 29800, Category.SHOES, "Flat Sandals.JPG");
            Item shoes6 = createItem("Fluffy Mary Jane Flats", 41900, Category.SHOES, "Fluffy Mary Jane Flats.JPG");
            Item shoes7 = createItem("Fur Buckle Slipper", 44000, Category.SHOES, "Fur Buckle Slipper.JPG");
            Item shoes8 = createItem("Platform Polished Loafers", 42000, Category.SHOES, "Platform Polished Loafers.JPG");
            Item shoes9 = createItem("Lace Up Chelsea Boots", 61000, Category.SHOES, "Lace Up Chelsea Boots.JPG");
            Item shoes10 = createItem("Slingbacks", 36000, Category.SHOES, "Slingbacks.JPG");
            Item shoes11 = createItem("Stiletto Pumps", 26900, Category.SHOES, "Stiletto Pumps.JPG");
            em.persist(shoes1); em.persist(shoes2); em.persist(shoes3); em.persist(shoes4);
            em.persist(shoes5); em.persist(shoes6); em.persist(shoes7); em.persist(shoes8);
            em.persist(shoes9); em.persist(shoes10); em.persist(shoes11);

            Item acc1 = createItem("3d Flower Crochet Tote Bag", 25000, Category.ACC, "3d Flower Crochet Tote Bag.JPG");
            Item acc2 = createItem("18k Daisy Decor Earrings", 13500, Category.ACC, "18k Daisy Decor Earrings.JPG");
            Item acc3 = createItem("Butterfly Decor Ring", 9100, Category.ACC, "Butterfly Decor Ring.JPG");
            Item acc4 = createItem("Cat Shape Massage Hair Comb", 12000, Category.ACC, "Cat Shape Massage Hair Comb.JPG");
            Item acc5 = createItem("Daisy Decor Chain Necklace", 16200, Category.ACC, "Daisy Decor Chain Necklace.JPG");
            Item acc6 = createItem("Fluffy Small Clutch", 38000, Category.ACC, "Fluffy Small Clutch.JPG");
            Item acc7 = createItem("Heart Baseball Cap", 15000, Category.ACC, "Heart Baseball Cap.JPG");
            Item acc8 = createItem("Heart Pattern Necklace", 6700, Category.ACC, "Heart Pattern Necklace.JPG");
            Item acc9 = createItem("Magnetic Holding Hands Eye Decor Crew Socks", 5400, Category.ACC, "Magnetic Holding Hands Eye Decor Crew Socks.JPG");
            Item acc10 = createItem("Metal Sunglasses", 22000, Category.ACC, "Metal Sunglasses.JPG");
            Item acc11 = createItem("Natural Stone & Faux Pearl Bracelet", 8900, Category.ACC, "Natural Stone & Faux Pearl Bracelet.JPG");
            Item acc12 = createItem("Nylon String Large Backpack", 38200, Category.ACC, "Nylon String Large Backpack.JPG");
            Item acc13 = createItem("Peach Hair Claw", 10900, Category.ACC, "Peach Hair Claw.JPG");
            em.persist(acc1); em.persist(acc2); em.persist(acc3); em.persist(acc4); em.persist(acc5);
            em.persist(acc6); em.persist(acc7); em.persist(acc8); em.persist(acc9); em.persist(acc10);
            em.persist(acc11); em.persist(acc12); em.persist(acc13);


            Cart cart1 = Cart.createcart(member, top1, 1L);
            Cart cart2 = Cart.createcart(member, acc4, 1L);

            OrderItem orderItem1 = OrderItem.createOrderItem(top1, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(acc4, 2);
            OrderItem orderItem3 = OrderItem.createOrderItem(top2, 2);

            List<OrderItem> orderItems1 = new ArrayList<>();
            orderItems1.add(orderItem1);
            orderItems1.add(orderItem2);

            List<OrderItem> orderItems2 = new ArrayList<>();
            orderItems2.add(orderItem3);


            Address address1 = createAddress(1L, "주소1");
            String address1_2 = address1.getAddressAsString();
            Address address2 = createAddress(1L, "주소1");
            String address2_2 = address2.getAddressAsString();
            Address address3 = createAddress(1L, "주소1");

            long cardnum = 123456789L;
            long amountpay = 100000L;
            Order order1 = Order.createOrder(member, address1_2, cardnum, amountpay, orderItems1);
            Order order2 = Order.createOrder(member, address2_2, cardnum, amountpay, orderItems2);


            em.persist(order1);
            em.persist(order2);
        }

        public Member createADMIN(MemberDTO memberFormDto, PasswordEncoder passwordEncoder) {
            Member member = new Member();
            member.setName(memberFormDto.getName());
            member.setEmail(memberFormDto.getEmail());
            member.setAddress(memberFormDto.getAddress());
            member.setRegistrationDate(LocalDateTime.now());
            String password = passwordEncoder.encode(memberFormDto.getPassword());
            member.setPassword(password);
            member.setRole(Role.ROLE_ADMIN); // 계정 생성 시 권한을 USER으로 고정

            return member;
        }

        public MemberDTO createTestAdminDTO() {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setName("ADMIN");
            memberDTO.setEmail("admin@hansung.ac.kr");
            memberDTO.setPassword("admin1234");
            memberDTO.setAddress("Test Address");
            memberDTO.setDate(LocalDateTime.now());
            return memberDTO;
        }


        public MemberDTO createTestMemberDTO() {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setName("Test User");
            memberDTO.setEmail("hansung@hansung.ac.kr");
            memberDTO.setPassword("1234");
            memberDTO.setAddress("Test Address");
            memberDTO.setDate(LocalDateTime.now());
            return memberDTO;
        }

        private Item createItem(String name, int price, Category category, String url) {
            Item item = new Item();
            item.setName(name);
            item.setPrice(price);
            item.setStockQuantity(100);
            item.setCategory(category);
            item.setImagePath(url);
            return item;
        }

        private Address createAddress(Long zipcode, String detail) {
            Address address = new Address();
            address.setZipcode(zipcode);
            address.setDetail(detail);
            return address;
        }
/*
            private Payment createPayment(Long cardnum ,Long amount) {

                Payment payment = new Payment();
                payment.setCardnumber(cardnum);
                payment.setAmountpay(amount);
                payment.setDate(LocalDateTime.now());
                return payment;
            }*/
    }
}