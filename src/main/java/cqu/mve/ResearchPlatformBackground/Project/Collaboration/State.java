package cqu.mve.ResearchPlatformBackground.Project.Collaboration;

public enum State {
    INITIATION("项目草稿",1),
    PLANNING("项目计划已发布",2),
    EXECUTION("项目正在讨论", 3),
    MONITORING("项目正在进行", 4),
    COMPLETION("项目完成待审阅", 5),
    REVIEW("项目审阅中", 6),
    CLOSURE("已结项", 7);

    final String describe;
    final int state_number;
    State(String describe, int state_number) {
        this.describe = describe;
        this.state_number = state_number;
    }

    public static State getStageByNumber(int state_number) {
        for (State state : State.values()) {
            if (state.state_number == state_number) {
                return state;
            }
        }

        throw new IllegalArgumentException("未知的状态编号: " + state_number);
    }

    public State nextState() {
        // 如果当前状态是CLOSURE，那么没有下一个状态
        if (this.ordinal() == State.values().length - 1) {
            throw new IndexOutOfBoundsException("状态已经无法变换");
        } else {
            return State.values()[this.ordinal() + 1];
        }
    }

    public String getDescribe() {
        return describe;
    }

    public int getStateNumber() {
        return state_number;
    }
}
