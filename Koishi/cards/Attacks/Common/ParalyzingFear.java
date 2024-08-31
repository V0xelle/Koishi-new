/*    */ package Koishi.cards.Attacks.Common;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.WeakPower;
/*    */ 
/*    */ public class ParalyzingFear extends AbstractDefaultCard {
/* 20 */   public static final String ID = KoishiMod.makeID(ParalyzingFear.class.getSimpleName());
/* 21 */   public static final String IMG = KoishiMod.makeCardPath("ParalyzingFear.png");
/*    */   
/* 23 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 24 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 25 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 26 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 9;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   private static final int DEBUFF = 2;
/*    */   private static final int UPGRADE_PLUS_DEBUFF = 1;
/*    */   
/*    */   public ParalyzingFear() {
/* 37 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 38 */     this.baseDamage = 9;
/* 39 */     this.magicNumber = this.baseMagicNumber = 2;
/* 40 */     KoishiMod.setBackground((CustomCard)this, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 45 */     KoishiMod.runAnimation("magicAttackB");
/* 46 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/*    */     
/* 48 */     if (m.hasPower(TerrorPower.POWER_ID)) {
/* 49 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)m, this.magicNumber, false), this.magicNumber));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 55 */     if (!this.upgraded) {
/* 56 */       upgradeName();
/* 57 */       upgradeDamage(3);
/* 58 */       upgradeMagicNumber(1);
/* 59 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Common/ParalyzingFear.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */