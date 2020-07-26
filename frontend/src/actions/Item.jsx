import * as actionType from "../constants/ActionType";

export const startGetItems = () => ({
  type: actionType.START_GET_ITEMS
});

export const getItemsResponse = (error, response) => ({
  type: actionType.GET_ITEMS_RESPONSE,
  payload: { error, response }
});

export const finishGetItems = () => ({
  type: actionType.FINISH_GET_ITEMS
});

export const startPostItem = (request) => ({
  type: actionType.START_POST_ITEM,
  payload: request
});

export const postItemResponse = (error, response) => ({
  type: actionType.POST_ITEM_RESPONSE,
  payload: { error, response }
})

export const finishPostItem = () => ({
  type: actionType.FINISH_POST_ITEM
})
