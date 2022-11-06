package com.moiza.moizaspringbootserver.follow.spi;

import com.moiza.moizaspringbootserver.follow.Follow;

public interface CommandFollowSpi {
	void saveFollow(Follow follow);
	void deleteFollow(Follow follow);
}
