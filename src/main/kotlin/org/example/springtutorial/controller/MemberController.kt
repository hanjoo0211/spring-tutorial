package org.example.springtutorial.controller

import org.example.springtutorial.domain.Member
import org.example.springtutorial.service.MemberService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MemberController(val memberService: MemberService) {

    @GetMapping("/members/new")
    fun createForm(): String {
        return "members/createMemberForm"
    }

    @PostMapping("/members/new")
    fun create(form: MemberForm): String {
        val member = Member()
        member.name = form.name

        memberService.join(member)

        return "redirect:/"
    }

    @GetMapping("/members")
    fun list(model: Model): String {
        val members = memberService.findMembers()
        model.addAttribute("members", members)
        return "members/memberList"
    }
}