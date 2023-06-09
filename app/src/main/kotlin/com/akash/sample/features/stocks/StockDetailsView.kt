package com.akash.sample.features.stocks

import com.google.gson.annotations.SerializedName

data class StockDetailsView(
    @SerializedName("avg_price") val avgPrice: String? = null,
    @SerializedName("cnc_used_quantity") val cncUsedQuantity: Int? = null,
    @SerializedName("collateral_qty") val collateralQty: Int? = null,
    @SerializedName("collateral_type") val collateralType: String? = null,
    @SerializedName("collateral_update_qty") val collateralUpdateQty: Int? = null,
    @SerializedName("company_name") val companyName: String? = null,
    @SerializedName("haircut") val haircut: Double? = null,
    @SerializedName("holdings_update_qty") val holdingsUpdateQty: Int? = null,
    @SerializedName("isin") val isin: String? = null,
    @SerializedName("product") val product: String? = null,
    @SerializedName("quantity") val quantity: Int? = null,
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("t1_holding_qty") val t1HoldingQty: Int? = null,
    @SerializedName("token_bse") val tokenBse: String? = null,
    @SerializedName("token_nse") val tokenNse: String? = null,
    @SerializedName("withheld_collateral_qty") val withheldCollateralQty: Int? = null,
    @SerializedName("withheld_holding_qty") val withheldHoldingQty: Int? = null,
    @SerializedName("ltp") val ltp: Double? = null,
    @SerializedName("close") val close: Double? = null,
)

