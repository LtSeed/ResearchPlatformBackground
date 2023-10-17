package cqu.mve.ResearchPlatformBackground.Records;

import lombok.Getter;
import lombok.Setter;

/**表示一个项目体现实现者的能力值<br>
 * 项目的复杂性和难度：<br>
 * --所用技术或概念的数量（例如，使用的不同技术或方法论的数量）。<br>
 * --项目涉及的学科领域数量。<br>
 * 解决问题的创新性和独创性：<br>
 * --新方法、技术或专利的数量。<br>
 * --相关行业或领域内引用或采纳的频率。<br>
 * 团队合作与领导能力：<br>
 * -参与的团队项目数量以及在这些项目中担任的角色（例如，领导者、主要贡献者等）。<br>
 * --下属或合作伙伴的反馈（通过调查或评价）。<br>
 * 学习能力：<br>
 * --新技能或证书的获取速度和数量。<br>
 * --完成项目或任务所需时间（学习曲线）。<br>
 * 项目管理：<br>
 * --成功完成的项目与延期或超预算项目的比率。<br>
 * --平均项目完成时间与预定时间的对比。<br>
 * 沟通能力：<br>
 * --反馈或评价的积极性（可以通过调查或评价获得）。<br>
 */
@Getter
@Setter
public class AbilityStatus {
    private int projectComplexity;
    private int innovativeness;
    private int teamworkLeadership;
    private int learningAbility;
    private int projectManagement;
    private int communicationSkills;
}
