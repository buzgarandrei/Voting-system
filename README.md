A back-end that implements a Voting system, where sessions with time interval can be set and users can access them and vote.
#
Bellow is a json copy that, open Postman, look for Import option, and there Paste Row Text. It will generate the http requests of this backend.
#
{
	"info": {
		"_postman_id": "a098ac8b-430a-4341-9548-9540be03cec5",
		"name": "Internship",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "login",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\"username\": \"popescu.ion\", \"password\": \"123\"}"
				},
				"url": {
					"raw": "http://localhost:8080/login",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"login"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "logout",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n   \r\n    \"token\": \"9b6bd06e-4f07-431a-8a4d-1aaffcb03e9b\"\r\n}"
				},
				"url": {
					"raw": "http://localhost:8080/logout",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"logout"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "userList",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"value": "834b6d51-2301-4984-b283-a28bc74976a5",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/userList",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"userList"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "addUser",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "35685d41-006d-412a-b435-740195165d2b"
					}
				],
				"body": {
					"mode": "raw",
					"raw": " {\r\n        \"cnp\": \"1234844890\",\r\n        \"password\": \"124\",\r\n        \"username\": \"popescu.vlad\",\r\n        \"name\":\"Popescu Vlad\",\r\n        \"address\":\"str. Ornitorincului nr.2A\", \r\n\t\t\"email\":\"popescu.vlad@gmail.com\", \r\n\t\t\"locality\":\"Cluj-Napoca\", \r\n\t\t\"county\":\"Cluj\"\r\n}"
				},
				"url": {
					"raw": "http://localhost:8080/addUser",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"addUser"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "updateUser",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "74b2aa8b-bd3a-47fe-998b-6a6a138fab4e"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n        \"id\": 21,\r\n        \"cnp\": \"1234567890\",\r\n        \"name\": \"Popescu Ion\",\r\n        \"username\": \"popescu.ion\",\r\n        \"county\": \"Cluj\",\r\n        \"locality\": \"Cluj-Napoca\",\r\n        \"address\": \"str. Frunzisului nr.1A\",\r\n        \"email\": \"popescu.ion@gmail.com\"\r\n    }"
				},
				"url": {
					"raw": "http://localhost:8080/updateUser",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"updateUser"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "deleteUser",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "35685d41-006d-412a-b435-740195165d2b"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"id\": \"19\"\r\n}"
				},
				"url": {
					"raw": "http://localhost:8080/deleteUser",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"deleteUser"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "activateUser",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "edadeddf-d977-4d0b-89ea-13a1f1cd2a55"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\"id\": \"3\", \"activation\": \"true\"}"
				},
				"url": {
					"raw": "http://localhost:8080/activateUser",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"activateUser"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "votingSessionList",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "caeb2b1a-5475-410f-beba-15bb92eef556"
					}
				],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/votingSessionList",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"votingSessionList"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "addVotingSession",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "44fb0440-feac-4496-9069-d903ae09d044"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\"dateStart\":\"2019-08-07 08:00\", \"dateEnd\":\"2019-08-20 22:00\" , \"nameOfVotingSession\":\"Electorale 2019 A\"}"
				},
				"url": {
					"raw": "http://localhost:8080/addVotingSession",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"addVotingSession"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "updateVotingSession",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "34fcbe93-dcbc-48df-b57f-5ff12f1295a7"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\"id\":\"9\", \n\"dateStart\":\"2019-08-08 08:00\", \n\"dateEnd\":\"2020-08-08 23:00\" , \n\"nameOfVotingSession\":\"Electorale 2019 FF\"}"
				},
				"url": {
					"raw": "http://localhost:8080/updateVotingSession",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"updateVotingSession"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "deleteVotingSession",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "a5f00396-7788-41e0-94b9-ac8f91e808a0"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\"id\":\"9\"}"
				},
				"url": {
					"raw": "http://localhost:8080/deleteVotingSession",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"deleteVotingSession"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "assignCandidateToVotingSession",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "34fcbe93-dcbc-48df-b57f-5ff12f1295a7"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\"userCandidateId\":\"21\", \"votingSessionId\": \"3\"}"
				},
				"url": {
					"raw": "http://localhost:8080/assignCandidateToVotingSession",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"assignCandidateToVotingSession"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "votingSessionCandidateList",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "34fcbe93-dcbc-48df-b57f-5ff12f1295a7"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\"id\":\"3\"}"
				},
				"url": {
					"raw": "http://localhost:8080/votingSessionCandidateList",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"votingSessionCandidateList"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "voteList",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/voteList",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"voteList"
					]
				}
			},
			"response": []
		},
		{
			"name": "addVote",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "1a4fd346-1ca9-4932-b742-37535aeb2ebb"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{ \"userCandidate\":\"1\", \"votingSession\":\"3\"}"
				},
				"url": {
					"raw": "http://localhost:8080/addVote",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"addVote"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "deleteVote",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					},
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "c8299f76-ef9e-42fc-a08b-4fcd38d6e5e9"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{  \"id\":\"8\"}"
				},
				"url": {
					"raw": "http://localhost:8080/deleteVote",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"deleteVote"
					]
				},
				"description": "vf"
			},
			"response": []
		},
		{
			"name": "voteResults",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "REQUEST_HEADER_TOKEN",
						"type": "text",
						"value": "ce5edcd0-297e-448e-8d59-6af85f8e1121"
					},
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{ \"votingSessionId\":\"3\" }"
				},
				"url": {
					"raw": "http://localhost:8080/voteResults",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"voteResults"
					],
					"query": [
						{
							"key": "",
							"value": "",
							"disabled": true
						}
					]
				}
			},
			"response": []
		}
	],
	"protocolProfileBehavior": {}
}
