package mgopesa

import (
	"github.com/go-pesa/go-pesa"
	"github.com/go-pesa/go-pesa/result"
)

var client = gopesa.EmptyClient()

//Client exports the config object to serve as an interface to the client instance
type Client gopesa.Config

//StkResponse is a response from an stkpush
type StkResponse result.StkResponse

//NewClient Creates a config object which is basically a dummy client
func NewClient() *Client { return &Client{} }

//Create initializes the client
func (c *Client) Create(key, secret string) {
	config := gopesa.Config(*c)
	options := config.CreateConfig()
	client = gopesa.New(key, secret, options...)
}

//StkPush Export
func (c *Client) StkPush(amount int, customerPhone, ref, desc string) *StkResponse {
	StkResponse := mapStkResponse(client.StkPush(amount, customerPhone, ref, desc))
	return &StkResponse
}

//StkPushQuery Export
func (c *Client) StkPushQuery(CheckoutRequestID string) *StkResponse {
	StkResponse := mapStkResponse(client.StkPushQuery(CheckoutRequestID))
	return &StkResponse
}

func mapStkResponse(resp result.StkResponse) StkResponse {
	return StkResponse{
		MerchantRequestID:   resp.MerchantRequestID,
		CheckoutRequestID:   resp.CheckoutRequestID,
		ResponseCode:        resp.ResponseCode,
		ResultDesc:          resp.ResultDesc,
		ResponseDescription: resp.ResponseDescription,
		ResultCode:          resp.ResultCode,
	}
}
