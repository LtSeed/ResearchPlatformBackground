package cqu.mve.ResearchPlatformBackground.Records;

import cqu.mve.ResearchPlatformBackground.Message.MessageReceiver;
import cqu.mve.ResearchPlatformBackground.Message.MessageSender;

/**
 * 表示一个用户给另一个用户发的私信
 * @param sender
 * @param receiver
 * @param content
 */
public record Message(MessageSender sender, MessageReceiver receiver, String content) {
}
