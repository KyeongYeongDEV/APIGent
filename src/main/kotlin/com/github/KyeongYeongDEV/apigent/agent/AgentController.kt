package com.github.KyeongYeongDEV.apigent.agent

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/agent") // 이 컨트롤러의 모든 API는 /api/v1/agent 로 시작됩니다.
class AgentController(
    private val agentService: AgentService
) {

    /**
     * AI 시나리오 테스트 실행을 요청하는 API 엔드포인트입니다.
     * @param request 사용자가 보낸 Swagger URL과 시나리오가 담긴 요청 본문
     * @return 생성된 테스트의 ID와 현재 상태를 담은 응답
     */
    @PostMapping("/run-test")
    suspend fun runTest(@RequestBody request: ScenarioTestRequest): ScenarioTestResponse {
        // 1. 모든 실제 작업은 Service에 위임합니다.
        // Controller는 '어떻게' 테스트가 실행되는지 전혀 알 필요가 없습니다.
        val resultEntity = agentService.startTest(request)

        // 2. Service로부터 받은 결과(Entity)를 사용자에게 보여줄 DTO로 변환합니다.
        //    이렇게 하면 데이터베이스의 내부 구조(Entity)가 외부에 직접 노출되지 않아
        //    보안과 유연성이 크게 향상됩니다.
        return ScenarioTestResponse(
            testId = resultEntity.id!!,
            userScenario = resultEntity.userScenario,
            aiPlan = resultEntity.aiPlan ?: "No plan generated", // AI 계획이 아직 없으면 기본값 설정
            status = resultEntity.status
        )
    }
}