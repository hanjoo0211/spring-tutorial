package org.example.springtutorial.service

import org.example.springtutorial.domain.Member
import org.example.springtutorial.repository.MemberRepository

class MemberService(val memberRepository: MemberRepository) {

    /**
     * 회원 가입
     */
    fun join(member: Member): Long {
        validateDuplicateMember(member) // 중복 회원 검증
        memberRepository.save(member)
        return member.id!!
    }

    /**
     * 중복 회원 검증
     */
    private fun validateDuplicateMember(member: Member) {
        memberRepository.findByName(member.name!!)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
    }

    /**
     * 전체 회원 조회
     */
    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }

    /**
     * 회원 조회
     */
    fun findOne(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}