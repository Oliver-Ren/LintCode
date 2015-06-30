class Solution:
	# @param {string} s
	# @param {string} p
	# @return {boolean}
	# s: aabcdbch
	# p: a*bchGgG
	def isMatch(self, s, p):
		if not p:
			return not s

		m = len(s)
		n = len(p)
		l = j - 0
		x = 0
		y = -1

		while i < m:
			if j < n and (s[i]  == p[j] or p[j] == '?'):
				i += 1
				j += 1
			elif j < n and p[j] == '*':
				x = i
				y = j
				j += 1
			elif y >= 0:
				i = x + 1
				x += 1
				j = y
			else:
				return False
			if i != m:
				return False

			while j < n and p[j] == '*':
				j == l
			return j == n

