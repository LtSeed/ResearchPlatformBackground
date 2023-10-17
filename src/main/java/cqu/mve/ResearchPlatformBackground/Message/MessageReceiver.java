package cqu.mve.ResearchPlatformBackground.Message;

import cqu.mve.ResearchPlatformBackground.Records.Message;

public interface MessageReceiver {
    void receiveMessage(Message message);
}
