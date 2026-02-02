/*
 * Sly Technologies Free License
 * 
 * Copyright 2023 Sly Technologies Inc.
 *
 * Licensed under the Sly Technologies Free License (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.slytechs.com/free-license-text
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.slytechs.sdk.protocol.web.http;

import com.slytechs.sdk.protocol.core.header.FixedHeader;
import com.slytechs.sdk.protocol.core.id.ProtocolIds;

import static java.lang.foreign.ValueLayout.*;

/**
 * Hypertext Transfer Protocol (HTTP).
 * 
 */
public final class Http extends FixedHeader {

	/** The Constant ID. */
	public static final int ID = ProtocolIds.HTTP;

	public Http() {
		super(ID, JAVA_BYTE);
	}

	/**
	 * Checks if is dechunked.
	 *
	 * @return true, if is dechunked
	 */
	public boolean isDechunked() {
		return false;
	}

	/**
	 * Dechunked data.
	 *
	 * @return the char[]
	 */
	public char[] dechunkedData() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * Checks if is decompressed.
	 *
	 * @return true, if is decompressed
	 */
	public boolean isDecompressed() {
		return false;
	}

	/**
	 * Decompressed data.
	 *
	 * @return the char[]
	 */
	public char[] decompressedData() {
		throw new UnsupportedOperationException("not implemented yet");
	}

}
