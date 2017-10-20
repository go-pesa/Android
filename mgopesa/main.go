package mgopesa

import gopesa "github.com/go-pesa/go-pesa"

var client = gopesa.EmptyClient()

//Client exports the config object to serve as an interface to the client instance
type Client gopesa.Config

//StkResponse is a response from an stkpush
type StkResponse struct {
	MerchantRequestID   string `json:"MerchantRequestID"`
	CheckoutRequestID   string `json:"CheckoutRequestID"`
	ResponseCode        string `json:"ResponseCode"`
	ResultDesc          string `json:"ResultDesc"`
	ResponseDescription string `json:"ResponseDescription"`
	ResultCode          int    `json:"ResultCode"`
}

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
	response := client.StkPush(amount, customerPhone, ref, desc)
	resp := StkResponse(response)
	return &resp
}

//StkPushQuery Export
func (c *Client) StkPushQuery(CheckoutRequestID string) *StkResponse {
	// var response StkResponse
	response := client.StkPushQuery(CheckoutRequestID)
	resp := StkResponse(response)
	return &resp
}
