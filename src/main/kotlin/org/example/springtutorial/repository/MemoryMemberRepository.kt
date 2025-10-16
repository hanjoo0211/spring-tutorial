package org.example.springtutorial.repository

import org.example.springtutorial.domain.Member

class MemoryMemberRepository : MemberRepository {

    private var store: MutableMap<Long, Member> = mutableMapOf()
    private var sequence: Long = 0L

    override fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id!!] = member
        return member
    }

    override fun findById(id: Long): Member? {
        return store[id]
    }

    override fun findByName(name: String): Member? {
        return store.values.find { it.name == name }
    }

    override fun findAll(): List<Member> {
        return store.values.toList()
    }

    fun clearStore() {
        store.clear()
    }
}