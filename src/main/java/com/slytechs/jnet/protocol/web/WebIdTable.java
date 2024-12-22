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
package com.slytechs.jnet.protocol.web;

import static com.slytechs.jnet.protocol.api.pack.ProtocolPackTable.*;

import java.util.function.Supplier;

import com.slytechs.jnet.protocol.api.common.Header;
import com.slytechs.jnet.protocol.api.common.HeaderInfo;
import com.slytechs.jnet.protocol.api.common.HeaderOptionInfo;
import com.slytechs.jnet.protocol.api.common.HeaderSupplier;
import com.slytechs.jnet.protocol.api.common.Other;
import com.slytechs.jnet.protocol.api.pack.PackId;
import com.slytechs.jnet.protocol.api.pack.ProtocolPackTable;

/**
 * Core protocol pack. Table of all protocols included in the core protocol
 * pack.
 * 
 * @author Mark Bednarczyk
 *
 */
public enum WebIdTable implements HeaderInfo, PackId {

	/** The payload. */
	PACK(),

	/** The http. */
	HTTP(Http::new),

	/** The html. */
	HTML(Html::new),

	;

	/** The Constant WEB_ID_PACK. */
	// @formatter:off
	public static final int WEB_ID_PACK     = 0  | PACK_ID_WEB;
	
	/** The Constant WEB_ID_HTTP. */
	public static final int WEB_ID_HTTP     = 1  | PACK_ID_WEB;
	
	/** The Constant WEB_ID_HTML. */
	public static final int WEB_ID_HTML     = 2  | PACK_ID_WEB;
	// @formatter:on

	/**
	 * Value of.
	 *
	 * @param id the id
	 * @return the core header info
	 */
	public static WebIdTable valueOf(int id) {
		int pack = PackId.decodePackId(id);
		if (pack != ProtocolPackTable.PACK_ID_CORE)
			return null;

		int ordinal = PackId.decodeIdOrdinal(id);
		return values()[ordinal];
	}

	/** The id. */
	private final int id;

	/** The supplier. */
	private final HeaderSupplier supplier;

	/** The extensions supplier. */
	private final Supplier<HeaderOptionInfo[]> extensionsSupplier;

	/**
	 * Instantiates a new core header info.
	 */
	WebIdTable() {
		this.id = PackId.encodeId(ProtocolPackTable.CORE, ordinal());
		this.supplier = Other::new;
		this.extensionsSupplier = () -> HeaderOptionInfo.EMPTY_ARRAY;
	}

	/**
	 * Instantiates a new core header info.
	 *
	 * @param supplier the supplier
	 */
	WebIdTable(HeaderSupplier supplier) {
		this.id = PackId.encodeId(ProtocolPackTable.CORE, ordinal());
		this.supplier = supplier;
		this.extensionsSupplier = () -> HeaderOptionInfo.EMPTY_ARRAY;
	}

	/**
	 * Instantiates a new core header info.
	 *
	 * @param supplier           the supplier
	 * @param extensionsSupplier the extensions supplier
	 */
	WebIdTable(HeaderSupplier supplier, Supplier<HeaderOptionInfo[]> extensionsSupplier) {
		this.id = PackId.encodeId(ProtocolPackTable.CORE, ordinal());
		this.supplier = supplier;
		this.extensionsSupplier = extensionsSupplier;
	}

	/**
	 * Gets the extension infos.
	 *
	 * @return the extension infos
	 * @see com.slytechs.jnet.protocol.api.common.HeaderInfo#getOptionInfos()
	 */
	@Override
	public HeaderOptionInfo[] getOptionInfos() {
		return extensionsSupplier.get();
	}

	/**
	 * Gets the header id.
	 *
	 * @return the header id
	 * @see com.slytechs.jnet.protocol.api.common.HeaderInfo#id()
	 */
	@Override
	public int id() {
		return id;
	}

	/**
	 * To string id.
	 *
	 * @param id the id
	 * @return the core header info
	 */
	public static WebIdTable toStringId(int id) {
		return values()[PackId.decodeIdOrdinal(id)];
	}

	/**
	 * New header instance.
	 *
	 * @return the header
	 * @see com.slytechs.jnet.protocol.api.common.HeaderSupplier#newHeaderInstance()
	 */
	@Override
	public Header newHeaderInstance() {
		return (supplier != null) ? supplier.newHeaderInstance() : null;
	}

}
