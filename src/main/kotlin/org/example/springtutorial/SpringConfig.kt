package org.example.springtutorial

import org.example.springtutorial.repository.MemberRepository
import org.example.springtutorial.repository.MemoryMemberRepository
import org.example.springtutorial.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig {

    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository());
    }

    @Bean
    fun memberRepository(): MemberRepository {
        return MemoryMemberRepository();
    }
}