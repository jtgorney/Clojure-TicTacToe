; Author: Jacob Gorney

(ns tictactoe.core
	(:require [clojure.math.numeric-tower :as math]
	:require [clojure.set :as set])
	(:gen-class))

; Imports
(import 'javax.swing.JButton)
(import 'javax.swing.JPanel)
(import 'javax.swing.JFrame)
(import 'java.awt.event.ActionListener)
(import 'java.awt.GridLayout)
(import 'java.awt.Font)
(import 'javax.swing.JOptionPane)

(defn runGame []
	; Define some variables
	(def playerScore 0)
	(def computerScore 0)
	(def tieScore 0)
	(def playerX '#{})
	(def playerO '#{})
	(def allNums '#{0 1 2 3 4 5 6 7 8})

	; Define the frame
	(def frame (JFrame. "Tic Tac Toe"))
	(.setDefaultCloseOperation frame JFrame/EXIT_ON_CLOSE)
	(.setSize frame 400 400)
	(.setLocationRelativeTo frame nil)
	(.setResizable frame false)

	; Container panel
	(def panel (JPanel.))
	(.setLayout panel (GridLayout. 3 3))
	(.setContentPane frame panel)

	(def btn_x1y1 (JButton. " "))
	(def btn_x1y2 (JButton. " "))
	(def btn_x1y3 (JButton. " "))

	(def btn_x2y1 (JButton. " "))
	(def btn_x2y2 (JButton. " "))
	(def btn_x2y3 (JButton. " "))

	(def btn_x3y1 (JButton. " "))
	(def btn_x3y2 (JButton. " "))
	(def btn_x3y3 (JButton. " "))

	(.setName btn_x1y1 "0")
	(.setName btn_x1y2 "1")
	(.setName btn_x1y3 "2")

	(.setName btn_x2y1 "3")
	(.setName btn_x2y2 "4")
	(.setName btn_x2y3 "5")

	(.setName btn_x3y1 "6")
	(.setName btn_x3y2 "7")
	(.setName btn_x3y3 "8")

	(.setFont btn_x1y1 (Font. "Arial", 1, 50))
	(.setFont btn_x1y2 (Font. "Arial", 1, 50))
	(.setFont btn_x1y3 (Font. "Arial", 1, 50))

	(.setFont btn_x2y1 (Font. "Arial", 1, 50))
	(.setFont btn_x2y2 (Font. "Arial", 1, 50))
	(.setFont btn_x2y3 (Font. "Arial", 1, 50))

	(.setFont btn_x3y1 (Font. "Arial", 1, 50))
	(.setFont btn_x3y2 (Font. "Arial", 1, 50))
	(.setFont btn_x3y3 (Font. "Arial", 1, 50))

	(.add panel btn_x1y1)
	(.add panel btn_x1y2)
	(.add panel btn_x1y3)

	(.add panel btn_x2y1)
	(.add panel btn_x2y2)
	(.add panel btn_x2y3)

	(.add panel btn_x3y1)
	(.add panel btn_x3y2)
	(.add panel btn_x3y3)

	; Show the score
	(defn showScores []
		(JOptionPane/showMessageDialog nil (clojure.string/join ["Scoreboard:\n\n", "Player: " playerScore, "\n" "Computer: " computerScore "\n" "Ties: " tieScore]) "Scoreboard" JOptionPane/INFORMATION_MESSAGE)
	)

	; Declare no winner
	(defn declareNoWinner[]
		(def tieScore (+ tieScore 1))
		(JOptionPane/showMessageDialog nil "The game is a tie!" "Tie Game" JOptionPane/INFORMATION_MESSAGE)
		(showScores)
		; Ask if we want to keep playing
		(def continuePlaying
			(JOptionPane/showConfirmDialog nil "Do you want to play another game?" "Play Another Game" JOptionPane/YES_NO_OPTION)
		)
		; Exit the system
		(if (not (= continuePlaying 0)) ((System/exit 0)))
		; Row 1
		(.setText btn_x1y1 "")
		(.setEnabled btn_x1y1 true)
		(.setText btn_x1y2 "")
		(.setEnabled btn_x1y2 true)
		(.setText btn_x1y3 "")
		(.setEnabled btn_x1y3 true)
		; Row 2
		(.setText btn_x2y1 "")
		(.setEnabled btn_x2y1 true)
		(.setText btn_x2y2 "")
		(.setEnabled btn_x2y2 true)
		(.setText btn_x2y3 "")
		(.setEnabled btn_x2y3 true)
		; Row 3
		(.setText btn_x3y1 "")
		(.setEnabled btn_x3y1 true)
		(.setText btn_x3y2 "")
		(.setEnabled btn_x3y2 true)
		(.setText btn_x3y3 "")
		(.setEnabled btn_x3y3 true)

		; Reset tracking
		(def playerO '#{})
		(def playerX '#{})
	)

	; Declare player O as the winner
	(defn declarePlayerO []
		(def playerScore (+ playerScore 1))
		(JOptionPane/showMessageDialog nil "Player O has won the game!" "Player O Won!" JOptionPane/INFORMATION_MESSAGE)
		(showScores)
		; Ask if we want to keep playing
		(def continuePlaying
			(JOptionPane/showConfirmDialog nil "Do you want to play another game?" "Play Another Game" JOptionPane/YES_NO_OPTION)
		)
		; Exit the system
		(if (not (= continuePlaying 0)) ((System/exit 0)))
		; Row 1
		(.setText btn_x1y1 "")
		(.setEnabled btn_x1y1 true)
		(.setText btn_x1y2 "")
		(.setEnabled btn_x1y2 true)
		(.setText btn_x1y3 "")
		(.setEnabled btn_x1y3 true)
		; Row 2
		(.setText btn_x2y1 "")
		(.setEnabled btn_x2y1 true)
		(.setText btn_x2y2 "")
		(.setEnabled btn_x2y2 true)
		(.setText btn_x2y3 "")
		(.setEnabled btn_x2y3 true)
		; Row 3
		(.setText btn_x3y1 "")
		(.setEnabled btn_x3y1 true)
		(.setText btn_x3y2 "")
		(.setEnabled btn_x3y2 true)
		(.setText btn_x3y3 "")
		(.setEnabled btn_x3y3 true)

		; Reset tracking
		(def playerO '#{})
		(def playerX '#{})
	)

	; Declare player X as winner
	(defn declarePlayerX []
		(def computerScore (+ computerScore 1))
		(JOptionPane/showMessageDialog nil "Player X has won the game!" "Player X Won!" JOptionPane/INFORMATION_MESSAGE)
		(showScores)
		; Ask if we want to keep playing
		(def continuePlaying
			(JOptionPane/showConfirmDialog nil "Do you want to play another game?" "Play Another Game" JOptionPane/YES_NO_OPTION)
		)
		; Exit the system
		(if (not (= continuePlaying 0)) ((System/exit 0)))
		; Row 1
		(.setText btn_x1y1 "")
		(.setEnabled btn_x1y1 true)
		(.setText btn_x1y2 "")
		(.setEnabled btn_x1y2 true)
		(.setText btn_x1y3 "")
		(.setEnabled btn_x1y3 true)
		; Row 2
		(.setText btn_x2y1 "")
		(.setEnabled btn_x2y1 true)
		(.setText btn_x2y2 "")
		(.setEnabled btn_x2y2 true)
		(.setText btn_x2y3 "")
		(.setEnabled btn_x2y3 true)
		; Row 3
		(.setText btn_x3y1 "")
		(.setEnabled btn_x3y1 true)
		(.setText btn_x3y2 "")
		(.setEnabled btn_x3y2 true)
		(.setText btn_x3y3 "")
		(.setEnabled btn_x3y3 true)

		; Reset tracking
		(def playerO '#{})
		(def playerX '#{})
	)

	; Check the game for a winner.
	(defn checkGame []
		; Define in which constitutes a win
		(def h1 '#{0 1 2}) ; Row 1
		(def h2 '#{3 4 5}) ; Row 2
		(def h3 '#{6 7 8}) ; Row 3
		(def v1 '#{0 3 6}) ; Col 1
		(def v2 '#{1 4 7}) ; Col 2
		(def v3 '#{2 5 8}) ; Col 3
		(def d1 '#{0 4 8}) ; Diagonal 1
		(def d2 '#{0 4 8}) ; Diagonal 2
		; Check player O
		(if (or (= (count (set/intersection playerO h1)) 3)
				(= (count (set/intersection playerO h2)) 3)
				(= (count (set/intersection playerO h3)) 3)
				(= (count (set/intersection playerO v1)) 3)
				(= (count (set/intersection playerO v2)) 3)
				(= (count (set/intersection playerO v3)) 3)
				(= (count (set/intersection playerO d1)) 3)
				(= (count (set/intersection playerO d2)) 3))
			(declarePlayerO)
		)
		; Check player X
		(if (or (= (count (set/intersection playerX h1)) 3)
				(= (count (set/intersection playerX h2)) 3)
				(= (count (set/intersection playerX h3)) 3)
				(= (count (set/intersection playerX v1)) 3)
				(= (count (set/intersection playerX v2)) 3)
				(= (count (set/intersection playerX v3)) 3)
				(= (count (set/intersection playerX d1)) 3)
				(= (count (set/intersection playerX d2)) 3))
			(declarePlayerX)
		)
		; Check no win
		(if (= (count (set/union playerX playerO)) 9) (declareNoWinner))
	)
	
	; Perform move
	(defn makeMove [event]
		; Player's choice
    	(.setText (.getSource event) "O")
    	(.setEnabled (.getSource event) false)
    	; Determine which button was clicked and add to moves list.
    	; Get the selected tile and add to the set
    	(def selected (. Integer parseInt (.getName (.getSource event))))
    	(def playerO (conj playerO selected))
    	(checkGame)

    	; Perform computer actions
    	; Generate random number
    	(def available (seq (set/difference allNums (set/union playerX playerO))))
    	(def tile (nth available (int (math/floor (rand (- (count available) 1))))))
    	; If it's the last tile
    	(if (= (count available) 1) (def tile (nth available 0)))
    	; Redefine playerX with the new selection
    	(def playerX (conj playerX tile))
    	; Now just mark the right button with X
    	; Row 1
    	(if (= tile 0) (
    	(fn [] 
    		(.setText btn_x1y1 "X")
    		(.setEnabled btn_x1y1 false)
    	)))
    	(if (= tile 1) (
    	(fn [] 
    		(.setText btn_x1y2 "X")
    		(.setEnabled btn_x1y2 false)
    	)))
    	(if (= tile 2) (
    	(fn [] 
    		(.setText btn_x1y3 "X")
    		(.setEnabled btn_x1y3 false)
    	)))
    	; Row 2
    	(if (= tile 3) (
    	(fn [] 
    		(.setText btn_x2y1 "X")
    		(.setEnabled btn_x2y1 false)
    	)))
    	(if (= tile 4) (
    	(fn [] 
    		(.setText btn_x2y2 "X")
    		(.setEnabled btn_x2y2 false)
    	)))
    	(if (= tile 5) (
    	(fn [] 
    		(.setText btn_x2y3 "X")
    		(.setEnabled btn_x2y3 false)
    	)))
    	; Row 3
    	(if (= tile 6) (
    	(fn [] 
    		(.setText btn_x3y1 "X")
    		(.setEnabled btn_x3y1 false)
    	)))
    	(if (= tile 7) (
    	(fn [] 
    		(.setText btn_x3y2 "X")
    		(.setEnabled btn_x3y2 false)
    	)))
    	(if (= tile 8) (
    	(fn [] 
    		(.setText btn_x3y3 "X")
    		(.setEnabled btn_x3y3 false)
    	)))

    	(checkGame)
	)

	; Define action listener for the button click
	(def buttonAction
        (proxy [ActionListener] []
        (actionPerformed [event]
        ; Determine who goes first
        (makeMove event)
    )))

	; Event listeners
	(.addActionListener btn_x1y1 buttonAction)
	(.addActionListener btn_x1y2 buttonAction)
	(.addActionListener btn_x1y3 buttonAction)

	(.addActionListener btn_x2y1 buttonAction)
	(.addActionListener btn_x2y2 buttonAction)
	(.addActionListener btn_x2y3 buttonAction)

	(.addActionListener btn_x3y1 buttonAction)
	(.addActionListener btn_x3y2 buttonAction)
	(.addActionListener btn_x3y3 buttonAction)

	; Show the frame
	(.setVisible frame true)

	; Show the GUI
	(JOptionPane/showMessageDialog nil "Welcome to Tic Tac Toe! Press OK to begin." "Tic Tac Toe" JOptionPane/INFORMATION_MESSAGE)
)

; Main function/entry point for application
(defn -main [& args] (
	runGame
))