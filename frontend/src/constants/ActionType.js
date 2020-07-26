const START_REQUEST = "_START_REQUEST";
const RECEIVE_DATA = "_RECEIVE_DATA";
const FINISH_REQUEST = "_FINISH_REQUEST";

const GET_ITEMS_PREFIX = "GET_ITEMS";
export const START_GET_ITEMS = GET_ITEMS_PREFIX + START_REQUEST;
export const GET_ITEMS_RESPONSE = GET_ITEMS_PREFIX + RECEIVE_DATA;
export const FINISH_GET_ITEMS = GET_ITEMS_PREFIX + FINISH_REQUEST;
const POST_ITEM_PREFIX = "POST_ITEM";
export const START_POST_ITEM = POST_ITEM_PREFIX + START_REQUEST;
export const POST_ITEM_RESPONSE = POST_ITEM_PREFIX + RECEIVE_DATA;
export const FINISH_POST_ITEM = POST_ITEM_PREFIX + FINISH_REQUEST;

const BRANDS_PREFIX = "BRANDS";
export const START_GET_BRANDS = BRANDS_PREFIX + START_REQUEST;
export const GET_BRANDS_RESPONSE = BRANDS_PREFIX + RECEIVE_DATA;
export const FINISH_GET_BRANDS = BRANDS_PREFIX + FINISH_REQUEST;

const GET_COLORS_PREFIX = "COLORS";
export const START_GET_COLORS = GET_COLORS_PREFIX + START_REQUEST;
export const GET_COLORS_RESPONSE = GET_COLORS_PREFIX + RECEIVE_DATA;
export const FINISH_GET_COLORS = GET_COLORS_PREFIX + FINISH_REQUEST;
