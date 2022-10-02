package com.moiza.moizaspringbootserver.follow.sqi;

import com.moiza.moizaspringbootserver.follow.Follow;

public interface CommandFollowSpi {
	void saveFollow(Follow follow);
}
