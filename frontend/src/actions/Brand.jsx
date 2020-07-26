import * as actionType from '../constants/ActionType';

export const startGetBrands = () => ({
  type: actionType.START_GET_BRANDS
});

export const getBrandsResponse = (error, response) => ({
  type: actionType.GET_BRANDS_RESPONSE,
  payload: { error, response }
});

export const finishGetBrands = () => ({
  type: actionType.FINISH_GET_BRANDS
})
