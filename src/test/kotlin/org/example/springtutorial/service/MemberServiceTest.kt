package org.example.springtutorial.service

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.example.springtutorial.domain.Member
import org.example.springtutorial.repository.MemoryMemberRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class MemberServiceTest {

    var memberRepository = MemoryMemberRepository()
    lateinit var memberService: MemberService

    @BeforeEach
    fun beforeEach() {
        memberRepository = MemoryMemberRepository()
        memberService = MemberService(memberRepository)
    }


    @AfterEach
    fun afterEach() {
        memberRepository.clearStore()
    }

    @Test
    fun 회원가입() {
        // given
        val member = Member()
        member.name = "hello"

        // when
        val saveId = memberService.join(member)

        // then
        val one = memberService.findOne(saveId)
        assertThat(member.name).isEqualTo(one?.name)
    }

    @Test
    fun 중복_회원_예외() {
        // given
        val member1 = Member()
        member1.name = "spring"

        val member2 = Member()
        member2.name = "spring"

        // when
        memberService.join(member1)
        val e = assertFailsWith<IllegalStateException> { memberService.join(member2) }
        assertThat(e.message).isEqualTo("이미 존재하는 회원입니다.")
    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }

}