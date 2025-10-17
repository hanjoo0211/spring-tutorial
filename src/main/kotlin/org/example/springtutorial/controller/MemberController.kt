package org.example.springtutorial.controller

import org.example.springtutorial.service.MemberService
import org.springframework.stereotype.Controller

@Controller
class MemberController(val memberService: MemberService) {

}